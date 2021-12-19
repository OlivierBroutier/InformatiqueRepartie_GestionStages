import { Component, OnInit } from '@angular/core';
import { Stage } from '../model/stage.model';
import { StageService } from '../shared/service/stage.service';

@Component({
    selector: 'app-stage',
    templateUrl: './stage.component.html',
    styleUrls: ['./stage.component.css']
})
export class StageComponent implements OnInit {

    public stages : Stage[] = [];

    constructor(private stage_service : StageService) {

    }

    async ngOnInit(): Promise<void> {
        this.stages = await this.stage_service.findAllStage();
    }

}
