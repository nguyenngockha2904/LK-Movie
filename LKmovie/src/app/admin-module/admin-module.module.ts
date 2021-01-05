import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AdminPageComponent } from './admin-page/admin-page.component';
import { LayoutModule } from '@angular/cdk/layout';
import { MaterialModule } from '../material/material.module';
import { RouterModule, Routes } from '@angular/router';
import { MoviesManageComponent } from './movies-manage/movies-manage.component';
import { UsersManageComponent } from './users-manage/users-manage.component';
import { HtRapCumRapManageComponent } from './ht-rap-cum-rap-manage/ht-rap-cum-rap-manage.component';
import { RapGheManageComponent } from './rap-ghe-manage/rap-ghe-manage.component';
const routes: Routes = [
  {
    path: '',
    component: AdminPageComponent,
    children: [
      { path: '', pathMatch: 'full', redirectTo: 'movies' },
      { path: 'movies', component: MoviesManageComponent },
      { path: 'users', component: UsersManageComponent },
      { path: 'hethongrap-cumrap', component: HtRapCumRapManageComponent },
      { path: 'rap-ghe', component: RapGheManageComponent },
    ],
  },
];
@NgModule({
  declarations: [
    AdminPageComponent,
    MoviesManageComponent,
    UsersManageComponent,
    HtRapCumRapManageComponent,
    RapGheManageComponent,
  ],
  imports: [
    CommonModule,
    LayoutModule,
    MaterialModule,
    RouterModule.forChild(routes),
  ],
  exports: [AdminPageComponent],
})
export class AdminModuleModule {}
