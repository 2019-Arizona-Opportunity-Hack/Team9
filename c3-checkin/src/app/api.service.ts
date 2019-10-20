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
      'Content-Type': 'application/json',
      Authorization: 'Basic ' + window.btoa('c3:12345')
    })
  };

  lookupByPhoneNumber(phoneNumber) {
    // return this.http.get(this.baseUrl + '/families?phone_number=' + phoneNumber, this.httpOptions);
    return this.http.get('./assets/data/families.json', this.httpOptions);
  }

  getServices() {
    return this.http.get(this.baseUrl + '/services', this.httpOptions);
    // return this.http.get('./assets/data/services.json', this.httpOptions);
  }
}
