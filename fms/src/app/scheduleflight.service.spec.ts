import { TestBed } from '@angular/core/testing';

import { ScheduleflightService } from './scheduleflight.service';

describe('ScheduleflightService', () => {
  let service: ScheduleflightService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ScheduleflightService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
