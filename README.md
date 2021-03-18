## Endpoints

### POST

| TYPE | Endpoint | Description | Return |
| :--: | :------: | :---------: | :----: |
| POST | `/generatekey` | generates a key, post body contains the current configuration of the server | (string) key and (string) secret |
| GET  | `/downloadedits/get?key=<KEY>&secret=<SECRET>` | downloads all changes from the webeditor, after download the changes are going to be deleted | configchanges |

