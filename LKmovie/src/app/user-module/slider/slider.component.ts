import {
  ChangeDetectionStrategy,
  Component,
  OnInit,
  ViewEncapsulation,
} from '@angular/core';

@Component({
  selector: 'app-slider',
  templateUrl: './slider.component.html',
  styleUrls: ['./slider.component.scss'],
  encapsulation: ViewEncapsulation.None,
})
export class SliderComponent implements OnInit {
  slides = [
    { img: '../../../assets/images/slide/hero-1.jpg' },
    { img: '../../../assets/images/slide/hero-2.jpg' },
    { img: '../../../assets/images/slide/hero-3.jpg' },
  ];
  slickNext = `<button class="slick-next"><img src="../../../assets/images/btnNextDark.svg" alt="" ></button>`;
  slickPrev = `<button class="slick-prev"><img src="../../../assets/images/btnPrevDark.svg" alt="" ></button>`;
  slideConfig = {
    slidesToShow: 1,
    slidesToScroll: 1,
    useCSS: true,
    dots: true,
    prevArrow: this.slickPrev,
    nextArrow: this.slickNext,
    fade: true,
    arrows: false,
  };
  constructor() {}

  ngOnInit(): void {}
}
