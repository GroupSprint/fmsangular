import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateairportComponent } from './createairport.component';

describe('CreateairportComponent', () => {
  let component: CreateairportComponent;
  let fixture: ComponentFixture<CreateairportComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateairportComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateairportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
