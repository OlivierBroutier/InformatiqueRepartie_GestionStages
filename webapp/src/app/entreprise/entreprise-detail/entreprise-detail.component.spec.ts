import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EntrepriseDetailComponent } from './entreprise-detail.component';

describe('EntrepriseDetailComponent', () => {
  let component: EntrepriseDetailComponent;
  let fixture: ComponentFixture<EntrepriseDetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EntrepriseDetailComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EntrepriseDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
