import { Component, OnInit } from '@angular/core';
import { Stage } from '../model/stage.model';
import { StageService } from '../shared/service/stage.service';
import {Router} from "@angular/router";
import {SuccessService} from "../shared/service/success.service";

@Component({
    selector: 'app-stage',
    templateUrl: './stage.component.html',
    styleUrls: ['./stage.component.css']
})
export class StageComponent implements OnInit {

    public stages : Stage[] = [];

    constructor(private stage_service : StageService,private router: Router,
    private success_service : SuccessService) {

    }

    async ngOnInit(): Promise<void> {
        this.stages = await this.stage_service.findAllStage();
    }

    public editStage(stage: Stage) : void {
        this.router.navigate(['/stage/modif/'+stage.id], { state: { stage } });
    }

    public async removeStage(stage: Stage) : Promise<void> {
        if(stage.id) {
            await this.stage_service.deleteStage(String(stage.id));
            this.success_service.createSuccessAlert('Succès', 'Le stage a bien été supprimé');
            this.stages = [...this.stages].filter(e => e.id !== stage.id);
        }


    }
}
