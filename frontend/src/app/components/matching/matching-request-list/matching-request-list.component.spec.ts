import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MatchingRequestListComponent } from './matching-request-list.component';

describe('MatchingRequestListComponent', () => {
  let component: MatchingRequestListComponent;
  let fixture: ComponentFixture<MatchingRequestListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MatchingRequestListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MatchingRequestListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
