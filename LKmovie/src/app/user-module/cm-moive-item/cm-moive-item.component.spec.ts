import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CmMoiveItemComponent } from './cm-moive-item.component';

describe('CmMoiveItemComponent', () => {
  let component: CmMoiveItemComponent;
  let fixture: ComponentFixture<CmMoiveItemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CmMoiveItemComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CmMoiveItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
