import { Http, Response } from '@angular/http';
import { Injectable } from '@angular/core';
import 'rxjs/add/operator/map';

@Injectable()
export class DialogItemService {
    constructor(private _http: Http) {}

    retrieveDialogItem(itemId: string) {
        return this._http.get('http://localhost:8080/tree-model-rest/dialog/' + itemId)
            .map((res:Response) => res.json());
    }
}
