import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewpassengerComponent } from './viewpassenger.component';

describe('ViewpassengerComponent', () => {
  let component: ViewpassengerComponent;
  let fixture: ComponentFixture<ViewpassengerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewpassengerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewpassengerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
