import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PhonelookupComponent } from './phonelookup/phonelookup.component';
import { VerifyComponent } from './verify/verify.component';
import { ServicesComponent } from './services/services.component';
import { WhoneedsComponent } from './whoneeds/whoneeds.component';
import { ThanksComponent } from './thanks/thanks.component';
import { EmployeeloginComponent } from './employeelogin/employeelogin.component';
import {RouterModule, Routes} from '@angular/router';
import { LoginComponent } from './login/login.component';
import {ReactiveFormsModule} from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    PhonelookupComponent,
    VerifyComponent,
    ServicesComponent,
    WhoneedsComponent,
    ThanksComponent,
    EmployeeloginComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
