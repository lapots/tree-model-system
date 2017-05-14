import { OnInit, OnDestroy, Component } from "@angular/core";
import { DialogItemService } from "./dialogItem.service";

@Component({
    selector: 'dialogItem',
    templateUrl: 'dialogItem.component.html',
    providers: [DialogItemService]
})
export class DialogItemComponent implements OnInit, OnDestroy {
    private dialogItemResponse: string;
    private _subscription;

    constructor(private _dialogItemService: DialogItemService) {}

    ngOnInit(): void {
        this._subscription = this._dialogItemService.retrieveDialogItem('HELLO_ID')
            .subscribe(
                (data) => {
                    this.dialogItemResponse = JSON.stringify(data);
                },
                (err) => console.log(err),
                () => console.log('dialog item service')
            );
    }

    ngOnDestroy(): void {
        this._subscription.unsubscribe();
    }

}
