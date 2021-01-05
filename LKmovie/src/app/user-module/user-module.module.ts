import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserMouduleComponent } from './user-moudule/user-moudule.component';
import { MaterialModule } from '../material/material.module';
import { FormsModule } from '@angular/forms';
import { HeaderComponent } from './header/header.component';
import { SliderComponent } from './slider/slider.component';
import { MovieListComponent } from './movie-list/movie-list.component';
import { MovieItemComponent } from './movie-item/movie-item.component';
import { ShowtimeMovieComponent } from './showtime-movie/showtime-movie.component';
import { ShowtimeMovieItemComponent } from './showtime-movie-item/showtime-movie-item.component';
import { CommingSoonComponent } from './comming-soon/comming-soon.component';
import { CmMoiveItemComponent } from './cm-moive-item/cm-moive-item.component';
import { FooterComponent } from './footer/footer.component';
import { HomePageComponent } from './home-page/home-page.component';
import { DetailMoviePageComponent } from './detail-movie-page/detail-movie-page.component';
import { SidenavComponent } from './sidenav/sidenav.component';
import { SlickCarouselModule } from 'ngx-slick-carousel';
import { RouterModule, Routes } from '@angular/router';
const routes: Routes = [{ path: '', component: HomePageComponent }];

@NgModule({
  declarations: [
    UserMouduleComponent,
    HeaderComponent,
    SliderComponent,
    MovieListComponent,
    MovieItemComponent,
    ShowtimeMovieComponent,
    ShowtimeMovieItemComponent,
    CommingSoonComponent,
    CmMoiveItemComponent,
    FooterComponent,
    HomePageComponent,
    DetailMoviePageComponent,
    SidenavComponent,
  ],
  imports: [
    CommonModule,
    MaterialModule,
    FormsModule,
    SlickCarouselModule,
    RouterModule.forChild(routes),
  ],
  exports: [UserMouduleComponent],
})
export class UserModuleModule {}
