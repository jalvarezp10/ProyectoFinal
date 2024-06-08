
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class YouTubeService {
  private apiKey = 'AIzaSyBeci1ePPOEEXODZ2kybO4tAaMgKErud0w';
  private apiUrl = 'https://www.googleapis.com/youtube/v3/search';

  constructor(private http: HttpClient) {}

  searchVideos(query: string): Observable<any> {
    const url = `${this.apiUrl}?q=${query}&key=${this.apiKey}&part=snippet&type=video&maxResults=1`;
    return this.http.get<any>(url);
  }
}

