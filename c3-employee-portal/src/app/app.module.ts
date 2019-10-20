import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SignInComponent } from './sign-in/sign-in.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HomeComponent } from './home/home.component';
import { HeaderComponent } from './header/header.component';
import { PrimaryhouseholdComponent } from './primaryhousehold/primaryhousehold.component';
import { FormsModule } from '@angular/forms';
import { AddmemberQuestionComponent } from './addmember-question/addmember-question.component';
import { AddmembersComponent } from './addmembers/addmembers.component';
import { SuccessComponent } from './success/success.component';
import { MembersearchComponent } from './membersearch/membersearch.component';
import { AddmemberComponent } from './addmember/addmember.component';
import { MemberSearchResultComponent } from './member-search-result/member-search-result.component';
import { ReportServiceSelectorComponent } from './report-service-selector/report-service-selector.component';
import { ReportDatesSelectorComponent } from './report-dates-selector/report-dates-selector.component';
import { HttpClientModule } from '@angular/common/http';
import { EditmemberComponent } from './editmember/editmember.component';

@NgModule({
  declarations: [
    AppComponent,
    SignInComponent,
    HomeComponent,
    HeaderComponent,
    PrimaryhouseholdComponent,
    AddmemberQuestionComponent,
    AddmembersComponent,
    SuccessComponent,
    MembersearchComponent,
    AddmemberComponent,
    MemberSearchResultComponent,
    ReportServiceSelectorComponent,
    ReportDatesSelectorComponent,
    EditmemberComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [HttpClientModule],
  bootstrap: [AppComponent]
})
export class AppModule { }
