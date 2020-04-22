import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GoalStatsComponent } from './goal-stats.component';

describe('GoalStatsComponent', () => {
  let component: GoalStatsComponent;
  let fixture: ComponentFixture<GoalStatsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GoalStatsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GoalStatsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
