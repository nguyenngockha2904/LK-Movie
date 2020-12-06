import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowtimeMovieItemComponent } from './showtime-movie-item.component';

describe('ShowtimeMovieItemComponent', () => {
  let component: ShowtimeMovieItemComponent;
  let fixture: ComponentFixture<ShowtimeMovieItemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ShowtimeMovieItemComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowtimeMovieItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
