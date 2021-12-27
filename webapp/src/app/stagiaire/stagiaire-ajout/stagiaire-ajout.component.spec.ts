import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StagiaireAjoutComponent } from './stagiaire-ajout.component';

describe('StagiaireAjoutComponent', () => {
  let component: StagiaireAjoutComponent;
  let fixture: ComponentFixture<StagiaireAjoutComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StagiaireAjoutComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StagiaireAjoutComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
