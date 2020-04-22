import { TestBed } from '@angular/core/testing';

import { GoalStatsService } from './goal-stats.service';

describe('GoalStatsService', () => {
  let service: GoalStatsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GoalStatsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
