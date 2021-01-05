import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  {
    path: 'admin',
    loadChildren: () =>
      import('../admin-module/admin-module.module').then(
        (m) => m.AdminModuleModule
      ),
  },
  {
    path: '',
    loadChildren: () =>
      import('../user-module/user-module.module').then(
        (m) => m.UserModuleModule
      ),
  },
  {
    path: '',
    loadChildren: () =>
      import('../authentication/authentication.module').then(
        (m) => m.AuthenticationModule
      ),
  },
];

@NgModule({
  declarations: [],
  imports: [[RouterModule.forRoot(routes)]],
  exports: [RouterModule],
})
export class AppRoutingModule {}
// export const routingComponents = [AdminPageComponent, UserMouduleComponent];
