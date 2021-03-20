## Endpoints

### POST

| TYPE | Endpoint | Description | Return | 
| :--: | :------: | :---------: | :----: | 
| POST | `/generatekey` | generates a key, post body contains the current configuration of the server | (string)
key and (string) secret | | GET | `/downloadedits/get?key=<KEY>&secret=<SECRET>` | downloads all changes from the webeditor, after download the changes are going to be deleted | configchanges |

## Properties of stuff

### Key and Secret

#### Key

- Alphanumeric string that has a length of 15. E.g.: `Emacr5YWSQjb1Kc`

#### Secret

- Alphanumeric string that has a length of 20. E.g.: `LZUri1M2jxkCWBZQC5gf` 
