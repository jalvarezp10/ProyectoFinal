import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FestivalesComponent } from './festivales.component';

describe('FestivalesComponent', () => {
  let component: FestivalesComponent;
  let fixture: ComponentFixture<FestivalesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FestivalesComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FestivalesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
