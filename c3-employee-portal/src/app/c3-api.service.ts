import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { apiUrl } from 'src/environments/environment';
import { Caregiver } from 'src/models/caregiver';

@Injectable({
  providedIn: 'root'
})
export class C3ApiService {
  protected httpOptions = {
    headers: this.getHeaders()
  };

  private getHeaders(): HttpHeaders {
    const headers: HttpHeaders = new HttpHeaders({
      'Content-Type': 'application/json;charset=utf-8',
      Accept: 'application/json;text/plain;*/*',
      Authorization: 'Basic ' + window.btoa('c3:12345')
    });

    return headers;
  }

  constructor(private http: HttpClient) {
  }

  public getServices<T>(): Observable<T> {
    return this.http.get<T>(apiUrl + 'services', this.httpOptions);
  }

  public addFamily<T>(caregiver: Caregiver): Observable<T> {
    return this.http.post<T>(apiUrl + 'family', caregiver, this.httpOptions);
  }

  public getFamilies<T>(lastName: string, dateOfBirth: string, phoneNumber: string): Observable<T> {
    let queryParameters = '';
    if (lastName.length > 0) {
      queryParameters = '?last_name=' + lastName.trim();
    }

    const parsedDob = Date.parse(dateOfBirth);
    if (!isNaN(parsedDob)) {
      const dob = new Date(dateOfBirth);
      const dobString = dob.getFullYear().toString() +
        ('0' + (dob.getMonth() + 1)).slice(-2) +
        ('0' + dob.getDate()).slice(-2);
      if (queryParameters.length > 0) {
        queryParameters += '&date_of_birth=' + dobString;
      } else {
        queryParameters += '?date_of_birth=' + dobString;
      }
    }

    if (phoneNumber.length > 0){
      if (queryParameters.length > 0) {
        queryParameters += '&phone_number=' + phoneNumber;
      } else {
        queryParameters += '?phone_number=' + phoneNumber;
      }
    }

    let url = apiUrl + 'families';
    if (queryParameters) {
      url += queryParameters;
    }
    console.log(url);
    return this.http.get<T>(url, this.httpOptions);
  }
}
