import { Component } from '@angular/core';
import { MessageService } from './shared/service/message.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'webapp';

  constructor(
      private messageService: MessageService
  ) {
      this.messageService.sendMessagesNonLusAlert();
  }
}
