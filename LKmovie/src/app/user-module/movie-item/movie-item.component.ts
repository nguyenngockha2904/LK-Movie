import { Component, Input, OnInit, ViewEncapsulation } from '@angular/core';

@Component({
  selector: 'app-movie-item',
  templateUrl: './movie-item.component.html',
  styleUrls: ['./movie-item.component.scss'],
  encapsulation: ViewEncapsulation.None,
})
export class MovieItemComponent implements OnInit {
  @Input() movieItem: any;
  listStar: string[] = [];
  constructor() {}

  ngOnInit(): void {
    let times =
      this.movieItem.raiting % 2 > 0
        ? this.movieItem.raiting / 2 + 0.5
        : this.movieItem.raiting / 2;
    for (let i = 1; i <= times; i++) {
      this.listStar.push(i + '');
    }
  }
}
