# Telepay API integration for Java

This repository is a Java implementation to interact with the Telepay Financial API.

The API control panel are in [https://cp.telepay.net](https://cp.telepay.net)

It provides interaction with many online payment providers like Ukash, PaysafeCard,
Bank Card, Online Wallets, etc. with a secure authentication and authorization mechanism.

## Installation
1. Get the code
  * download the latest compiled artifact [here](https://github.com/Telepay/Java-SDK/releases/download/v0.9/TelepayApi.jar)
2. Import the `TelepayApi.jar` in your project
 
 
## Basic sample
* **Sample Service:** for testing the right connection to the API
* **PagoFacil:** Credit and Debit bank card processing
* **Paynet Payment of services:** gives a way for pay many common services in Mexico
* **PayU:** a way for pay services in 7eleven and Oxxo, Mexico
* **SafetyPay:** online payments with your online banking credentials.
* **ToditoCash:** mexican pre-charged wallet for pay services and products online.
* **Ukash:** referenced payments with a vouchers without bank data.
* **Paynet reference:** generates reference barcodes for pay over internet without bank card data.

## The integration can be made like this:
```
import net.telepay.api.TelepayClient;
import net.telepay.api.core.Credentials;
import net.telepay.api.core.UserCredentials;
import net.telepay.api.responses.Response;

import java.io.IOException;

public class Main {

    private static final String ACCESS_KEY = "YOUR_TELEPAY_ACCESS_KEY";
    private static final String ACCESS_SECRET = "YOUR_TELEPAY_ACCESS_SECRET";

    public static void main(String[] args) {

        Credentials credentials = new UserCredentials(
                ACCESS_KEY, ACCESS_SECRET
        );
        /*"(test|real)", default is "real"*/
        TelepayClient tc = new TelepayClient(credentials, "test");

        System.out.println("Starting..");
        try {
            Response resp = tc.getSample().make();

            System.out.println("Call code=" + resp.getCode());
            System.out.println("Call message=" + resp.getMessage());
            System.out.println("Call data=" + resp.getData().toString());
            System.out.println("End");

        } catch (IOException e) {
            System.out.println("End with error: " + e.getMessage());
        }
    }
}
```



