import { Component, OnInit, ViewEncapsulation } from '@angular/core';

@Component({
  selector: 'app-showtime-movie',
  templateUrl: './showtime-movie.component.html',
  styleUrls: ['./showtime-movie.component.scss'],
  encapsulation: ViewEncapsulation.None,
})
export class ShowtimeMovieComponent implements OnInit {
  isTab: string = 'MON';
  constructor() {}

  ngOnInit(): void {}
  handleChangeTab(tab: string): void {
    this.isTab = tab;
  }
}
