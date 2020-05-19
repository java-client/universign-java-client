package com.universign.javaclient.ra;

/**
 * Defines the user certificate info
 */
public class CertificateInfo
{
    private String subjectDN;
    private String serialNumber;
    private byte[][] chain;

    CertificateInfo()
    {
        // package constructor
    }

    /**
     * Getter subjectDN
     *
     * @return subjectDN
     */
    public String getSubjectDN()
    {
        return subjectDN;
    }

    /**
     * Setter subjectDN
     *
     * @param subjectDN to set
     * @return CertificateInfo instance
     */
    public CertificateInfo setSubjectDN(String subjectDN)
    {
        this.subjectDN = subjectDN;
        return this;
    }

    /**
     * Getter serial number
     *
     * @return serialNumber
     */
    public String getSerialNumber()
    {
        return serialNumber;
    }

    /**
     * Setter serial number
     *
     * @param serialNumber to set
     * @return CertificateInfo instance
     */
    public CertificateInfo setSerialNumber(String serialNumber)
    {
        this.serialNumber = serialNumber;
        return this;
    }

    /**
     * Getter certificate chain
     *
     * @return chain
     */
    public byte[][] getChain()
    {
        return chain;
    }

    /**
     * Setter chain
     *
     * @param chain to set
     * @return CertificateInfo instance
     */
    public CertificateInfo setChain(byte[][] chain)
    {
        this.chain = chain;
        return this;
    }
}
