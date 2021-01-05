import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HtRapCumRapManageComponent } from './ht-rap-cum-rap-manage.component';

describe('HtRapCumRapManageComponent', () => {
  let component: HtRapCumRapManageComponent;
  let fixture: ComponentFixture<HtRapCumRapManageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HtRapCumRapManageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HtRapCumRapManageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
