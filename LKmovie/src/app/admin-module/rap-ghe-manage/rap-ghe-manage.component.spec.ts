import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RapGheManageComponent } from './rap-ghe-manage.component';

describe('RapGheManageComponent', () => {
  let component: RapGheManageComponent;
  let fixture: ComponentFixture<RapGheManageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RapGheManageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RapGheManageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
