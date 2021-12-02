import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MatchingRequestCardComponent } from './matching-request-card.component';

describe('MatchingRequestCardComponent', () => {
  let component: MatchingRequestCardComponent;
  let fixture: ComponentFixture<MatchingRequestCardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MatchingRequestCardComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MatchingRequestCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
