
## Synopsis

This client gives you access to the Universign API through a java client. You can:
- request a certificate
- create a signature session
- add users to your organization

## Code Examples

1. Example of signature session creation.

```java
private static TransactionResponse requestTransaction(String login, String password)
	throws UniversignClientException, IOException
{
	SignatureManager sigMgr = SignatureManager.create(login, password);

	DocSignatureField docSignField = new DocSignatureField();
	docSignField.setX(0);
	docSignField.setY(0);
	docSignField.setPage(-1)
	docSignField.setSignerIndex(0);

	TransactionSigner signer = new TransactionSigner();
	signer.setFirstname("Firstname");
	signer.setLastname("Lastname");
	signer.setSuccessURL("http://www.google.fr/search?q=success");
	signer.setFailURL("http://www.google.fr/search?q=fail");
	signer.setCancelURL("http://www.google.fr/search?q=cancel");

	TransactionDocument doc = new TransactionDocument();
	doc.setFileName("test.pdf");
	doc.setContent(Utils.loadDoc("path_to_doc"));
	doc.setSignatureFields(Arrays.asList(docSignField));

	TransactionRequest request = new TransactionRequest();
	request.setSigners(Arrays.asList(signer));
	request.setDocuments(Arrays.asList(doc));
	request.setCertificateType(CertificateType.CERTIFICATE_TYPE_SIMPLE);
	request.setLanguage(Language.LANGUAGE_FR);

	TransactionResponse response = sigMgr.requestTransaction(request);

	// must be saved for the second call
	System.out.println("ID: " + response.getId());
	// the URL where the client should be redirected to
	System.out.println("URL: " + response.getUrl());

	return response;
}
```

2. Example of signed documents retrieval.

```java
private static void getDocuments(String login, String password) throws UniversignClientException
{
	SignatureManager sigMgr = SignatureManager.create(login, password);
	TransactionDocument[] documents = sigMgr.getDocuments(TRANSACTION_ID);
	for (TransactionDocument d : documents) {
		System.out.println("fileName: " + d.getFileName());
	}
}
```

3. Example of certificate request.

```java
private static final String PATH_TO_ID_PHOTO_1 = "/path/to/corinne_berthier_1.jpg";
private static final String PATH_TO_ID_PHOTO_2 = "/path/to/corinne_berthier_2.jpg";

private static void requestRegistration(String login, String password)
	throws UniversignClientException, IOException
{
	SignatureManager sigMgr = SignatureManager.create(login, password);

	RegistrationRequest idDoc = new RegistrationRequest();
	idDoc.setType(IdDocumentTypes.ID_TYPE_ID_CARD_FR);
	byte[][] photos = new byte[2][];
	photos[0] = loadDoc(PATH_TO_ID_PHOTO_1);
	photos[1] = loadDoc(PATH_TO_ID_PHOTO_2);
	idDoc.setDocuments(photos);

	TransactionSigner signer = new TransactionSigner();
	signer.setFirstname("Corinne");
	signer.setLastname("Berthier");
	signer.setEmailAddress("mailto:test-email@domain.tld");
	signer.setPhoneNum("33600000000");
	signer.setCertificateType(CertificateType.CERTIFICATE_TYPE_CERTIFIED);
	signer.setIdDocuments(idDoc);

	Calendar cal = Calendar.getInstance();
	cal.set(1965, 11, 6);
	signer.setBirthDate(cal.getTime());

	StandaloneRegistrationRequest request = new StandaloneRegistrationRequest();
	request.setSigner(signer);

	TransactionResponse response = sigMgr.requestRegistration(request);

	// must be saved for the second call
	System.out.println("ID: " + response.getId());
	// the URL where the client should be redirected to
	System.out.println("URL: " + response.getUrl());
}
```

4. Example of adding user.

```java
private static void addUser(String login, String password) throws UniversignClientException
{
	UsersManager usersMgr = UsersManager.create(login, password);
	usersMgr.userAdd("test-email@domain.tld");
}
```