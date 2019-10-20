import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})

export class ApiService {

  // Base url
  baseUrl = 'https://chandler-care-center.herokuapp.com';

  constructor(private http: HttpClient) { }

  // Http Headers
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json',
      'Authorization': btoa('c3:12345')
    })
  };

  lookupByPhoneNumber(phoneNumber) {
    return this.http.get(this.baseUrl + '/families?phone_number=' + phoneNumber, this.httpOptions);
  }

  getServices() {
    // return this.http.get(this.baseUrl + '/services', this.httpOptions);
    return this.http.get('./assets/services.json', this.httpOptions);
  }
}
