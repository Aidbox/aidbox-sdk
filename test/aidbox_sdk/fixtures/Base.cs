namespace Aidbox.FHIR.Base;

public class Coding : Element
{
    public string? Code { get; set; }
    public string? System { get; set; }
    public string? Display { get; set; }
    public string? Version { get; set; }
    public bool? UserSelected { get; set; }
}