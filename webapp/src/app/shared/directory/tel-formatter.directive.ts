import { Directive, ElementRef, EventEmitter, HostListener, Input, OnChanges, Output, SimpleChanges } from '@angular/core';

@Directive({
    selector: '[telFormatter]'
})
export class TelFormatterDirective implements OnChanges {

    @Input() public ngModel: any;
    @Output() public readonly ngModelChange: EventEmitter<any> = new EventEmitter<any>();

    constructor(
        private ref: ElementRef
    ) { }

    public ngOnChanges(changes: SimpleChanges): void {
        if (!this.ngModel) {
            return;
        }

        const split = this.ngModel.split(' ');
        const lastPart = split[split.length - 1];

        if (lastPart.length === 2 && this.ngModel.length !== 14) {
            this.ref.nativeElement.value += ' ';
        }
    }

    @HostListener('blur', ['$event.target.value'])
    public onBlur(value: string): void {
        if (value.length === 10 && !value.includes(' ')) {
            const formattedValue = value.match(/.{1,2}/g)?.join(' ');
            if (formattedValue) {
                this.ref.nativeElement.value = formattedValue;
                this.ngModelChange.emit(formattedValue);
            }
        }
    }

}
