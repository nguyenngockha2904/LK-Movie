import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AuthenticationComponent } from './authentication.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { SignInComponent } from './sign-in/sign-in.component';
import { RouterModule, Routes } from '@angular/router';
import { MaterialModule } from '../material/material.module';

const routes: Routes = [
  {
    path: '',
    component: AuthenticationComponent,
    children: [
      { path: 'signin', component: SignInComponent },
      { path: 'signup', component: SignUpComponent },
    ],
  },
];

@NgModule({
  declarations: [AuthenticationComponent, SignUpComponent, SignInComponent],
  imports: [CommonModule, RouterModule.forChild(routes), MaterialModule],
  exports: [AuthenticationComponent],
})
export class AuthenticationModule {}
