import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateschflightComponent } from './createschflight.component';

describe('CreateschflightComponent', () => {
  let component: CreateschflightComponent;
  let fixture: ComponentFixture<CreateschflightComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateschflightComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateschflightComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
