import { AuxAlertEnum } from './aux-alert.enum';

export abstract class OgiAlert {
    name?: string;
    message?: string;
    type: AuxAlertEnum;

    protected constructor(type: AuxAlertEnum, name?: string, message?: string) {
        this.type = type;
        this.name = name;
        this.message = message;
    }
}

export class OgiSuccess extends OgiAlert{
    constructor(name?: string, message?: string) {
        super(AuxAlertEnum.SUCCESS, name, message);
    }
}

export class OgiError extends OgiAlert {
    code?: string;
    details?: string;

    constructor(name?: string, message?: string, code?: string, details?: string) {
        super(AuxAlertEnum.ERROR, name, message);
        this.code = code;
        this.details = details;
    }
}
