import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MatchingRequestComponent } from './matching-request.component';

describe('MatchingRequestComponent', () => {
  let component: MatchingRequestComponent;
  let fixture: ComponentFixture<MatchingRequestComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [MatchingRequestComponent]
    }).compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MatchingRequestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
