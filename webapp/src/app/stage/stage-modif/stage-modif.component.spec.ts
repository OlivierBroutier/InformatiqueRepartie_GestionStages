import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StageModifComponent } from './stage-modif.component';

describe('StageModifComponent', () => {
  let component: StageModifComponent;
  let fixture: ComponentFixture<StageModifComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StageModifComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StageModifComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
