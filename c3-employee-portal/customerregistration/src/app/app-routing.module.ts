import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SignInComponent } from './sign-in/sign-in.component';
import { HomeComponent } from './home/home.component';
import { PrimaryhouseholdComponent } from './primaryhousehold/primaryhousehold.component';
import { AddmemberQuestionComponent } from './addmember-question/addmember-question.component';
import { MembersearchComponent } from './membersearch/membersearch.component';
import { SuccessComponent } from './success/success.component';
import { AddmembersComponent } from './addmembers/addmembers.component';

const routes: Routes = [
  {
    path: '',
    component: SignInComponent,
    pathMatch: 'full'
  },
  {
    path: 'sign-in',
    component: SignInComponent
  },
  {
    path: 'home',
    component: HomeComponent
  },
  {
    path: 'primaryhousehold',
    component: PrimaryhouseholdComponent
  },
  {
    path: 'addmemberquestion',
    component: AddmemberQuestionComponent
  },
  {
    path: 'membersearch',
    component: MembersearchComponent
  },
  {
    path: 'success',
    component: SuccessComponent
  },
  {
    path: 'addmembers',
    component: AddmembersComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
