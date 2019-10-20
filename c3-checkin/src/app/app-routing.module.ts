import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {EmployeeloginComponent} from './employeelogin/employeelogin.component';
import {LoginComponent} from './login/login.component';
import {PhonelookupComponent} from './phonelookup/phonelookup.component';
import {VerifyComponent} from './verify/verify.component';
import {WhoneedsComponent} from './whoneeds/whoneeds.component';
import {ServicesComponent} from './services/services.component';
import {ThanksComponent} from './thanks/thanks.component';


const routes: Routes = [
  { path: '', component: EmployeeloginComponent },
  { path: 'login', component: LoginComponent },
  { path: 'phonelookup', component: PhonelookupComponent },
  { path: 'verify', component: VerifyComponent },
  { path: 'whoneeds', component: WhoneedsComponent },
  { path: 'services', component: ServicesComponent },
  { path: 'thanks', component: ThanksComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
