import { Component, OnInit, ViewEncapsulation } from '@angular/core';

@Component({
  selector: 'app-comming-soon',
  templateUrl: './comming-soon.component.html',
  styleUrls: ['./comming-soon.component.scss'],
  encapsulation: ViewEncapsulation.None,
})
export class CommingSoonComponent implements OnInit {
  slides = [
    {
      hinhAnh: '../../../assets/images/movies-img/movie-1.jpg',
      tenPhim: 'The last Post',
      raiting: 10,
    },
    {
      hinhAnh: '../../../assets/images/movies-img/movie-2.jpg',
      tenPhim: 'Killer bee',
      raiting: 7,
    },
    {
      hinhAnh: '../../../assets/images/movies-img/movie-3.jpg',
      tenPhim: 'Woste',
      raiting: 10,
    },
    {
      hinhAnh: '../../../assets/images/movies-img/movie-4.jpg',
      tenPhim: 'Jack',
      raiting: 9,
    },
    {
      hinhAnh: '../../../assets/images/movies-img/movie-5.jpg',
      tenPhim: 'Tom',
      raiting: 9,
    },
    {
      hinhAnh: '../../../assets/images/movies-img/movie-6.jpg',
      tenPhim: 'Waters',
      raiting: 8,
    },
    {
      hinhAnh: '../../../assets/images/movies-img/movie-7.jpg',
      tenPhim: 'Mouster',
      raiting: 5,
    },
    {
      hinhAnh: '../../../assets/images/movies-img/movie-8.jpg',
      tenPhim: 'King of K',
      raiting: 9,
    },
    {
      hinhAnh: '../../../assets/images/movies-img/movie-9.jpg',
      tenPhim: 'John swith',
      raiting: 10,
    },
    {
      hinhAnh: '../../../assets/images/movies-img/movie-10.jpg',
      tenPhim: 'Smiths',
      raiting: 8,
    },
    {
      hinhAnh: '../../../assets/images/movies-img/movie-11.jpg',
      tenPhim: 'Best Family',
      raiting: 7,
    },
    {
      hinhAnh: '../../../assets/images/movies-img/movie-12.jpg',
      tenPhim: 'Beef dead',
      raiting: 9,
    },
    {
      hinhAnh: '../../../assets/images/movies-img/movie-13.jpg',
      tenPhim: 'Roote',
      raiting: 10,
    },
    {
      hinhAnh: '../../../assets/images/movies-img/movie-14.jpg',
      tenPhim: 'Robin',
      raiting: 9,
    },
  ];
  slideConfig1 = {
    slidesToShow: 6,
    slidesToScroll: 6,
    arrows: true,
  };
  constructor() {}

  ngOnInit(): void {}
}
