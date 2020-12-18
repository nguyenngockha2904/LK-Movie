import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AdminPageComponent } from './admin-page/admin-page.component';
import { LayoutModule } from '@angular/cdk/layout';
import { MaterialModule } from '../material/material.module';

@NgModule({
  declarations: [AdminPageComponent],
  imports: [CommonModule, LayoutModule, MaterialModule],
  exports: [AdminPageComponent],
})
export class AdminModuleModule {}
