import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Mission } from '../../../model/mission.model';
import { ControlContainer, NgForm } from '@angular/forms';

@Component({
    selector: 'app-missions',
    templateUrl: './missions.component.html',
    styleUrls: ['./missions.component.css'],
    viewProviders: [
        { provide: ControlContainer, useExisting: NgForm }
    ]
})
export class MissionsComponent implements OnInit {

    @Input() missions: Mission[] = [];

    @Output() missionsChange: EventEmitter<Mission[]> = new EventEmitter<Mission[]>();

    constructor() { }

    ngOnInit(): void {
    }

    public addMission(): void {
        this.missions = [...this.missions, { }];
        this.missionsChange.emit(this.missions);
    }

    public removeMission(mission: Mission): void {
        this.missions = this.missions.filter(m => m !== mission);
        this.missionsChange.emit(this.missions);
    }

}
