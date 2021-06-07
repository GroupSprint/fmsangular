import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreatepassengerComponent } from './createpassenger.component';

describe('CreatepassengerComponent', () => {
  let component: CreatepassengerComponent;
  let fixture: ComponentFixture<CreatepassengerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreatepassengerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CreatepassengerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
