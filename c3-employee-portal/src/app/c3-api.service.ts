import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { apiUrl } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class C3ApiService {
  protected httpOptions = {
    headers: this.getHeaders()
  };

  private getHeaders(): HttpHeaders {
    const headers: HttpHeaders = new HttpHeaders({
      Authorization: 'Basic ' + window.btoa('c3:12345')
    });

    return headers;
  }

  constructor(private http: HttpClient) {
  }

  public getServices<T>(): Observable<T> {
    return this.http.get<T>(apiUrl + 'services', this.httpOptions);
  }

}
