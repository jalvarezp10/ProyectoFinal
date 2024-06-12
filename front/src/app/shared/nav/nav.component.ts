import { Component, OnDestroy, OnInit } from '@angular/core';
import { Router, NavigationEnd } from '@angular/router';
import { LoginService } from 'src/app/services/auth/login.service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit, OnDestroy {
  userLoginOn: boolean = false;
  showNavbar: boolean = true;
  private routerSubscription: Subscription = new Subscription();

  constructor(private loginService: LoginService, private router: Router) { }

  ngOnInit(): void {
    this.loginService.currentUserLoginOn.subscribe(
      {
        next: (userLoginOn) => {
          this.userLoginOn = userLoginOn;
        }
      }
    );

    this.routerSubscription = this.router.events.subscribe(event => {
      if (event instanceof NavigationEnd) {
        this.checkRoute(event.urlAfterRedirects);
      }
    });

    // Check the initial route
    this.checkRoute(this.router.url);
  }

  ngOnDestroy(): void {
    this.loginService.currentUserLoginOn.unsubscribe();
    this.routerSubscription.unsubscribe();
  }

  logout() {
    this.loginService.logout();
    this.router.navigate(['/login']);
  }

  private checkRoute(url: string): void {
    const hiddenRoutes = ['/login', '/register', '/'];
    this.showNavbar = !hiddenRoutes.includes(url);
  }
}
