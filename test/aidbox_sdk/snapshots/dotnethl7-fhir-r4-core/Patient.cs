using Aidbox.FHIR.Base;
using Aidbox.FHIR.Utils;

namespace Aidbox.FHIR.R4.Core;

public class Patient : DomainResource, IResource
{
    public bool? MultipleBirthBoolean { get; set; }
    public Base.Address[]? Address { get; set; }
    public string? DeceasedDateTime { get; set; }
    public Base.ResourceReference? ManagingOrganization { get; set; }
    public bool? DeceasedBoolean { get; set; }
    public Base.HumanName[]? Name { get; set; }
    public string? BirthDate { get; set; }
    public int? MultipleBirthInteger { get; set; }
    public object? MultipleBirth    
    {
        get
        {
            if (MultipleBirthBoolean is not null)
            {
                return MultipleBirthBoolean;
            }
    
            if (MultipleBirthInteger is not null)
            {
                return MultipleBirthInteger;
            }
    
            return null;
        }
    
        set
        {
            if (value?.GetType() == typeof(bool))
            {
                MultipleBirthBoolean = (bool)value;
                return;
            }
    
            if (value?.GetType() == typeof(int))
            {
                MultipleBirthInteger = (int)value;
                return;
            }
    
            throw new ArgumentException("Invalid type provided");
        }
    }
    public object? Deceased    
    {
        get
        {
            if (DeceasedDateTime is not null)
            {
                return DeceasedDateTime;
            }
    
            if (DeceasedBoolean is not null)
            {
                return DeceasedBoolean;
            }
    
            return null;
        }
    
        set
        {
            if (value?.GetType() == typeof(string))
            {
                DeceasedDateTime = (string)value;
                return;
            }
    
            if (value?.GetType() == typeof(bool))
            {
                DeceasedBoolean = (bool)value;
                return;
            }
    
            throw new ArgumentException("Invalid type provided");
        }
    }
    public Base.Attachment[]? Photo { get; set; }
    public Patient_Link[]? Link { get; set; }
    public bool? Active { get; set; }
    public Patient_Communication[]? Communication { get; set; }
    public Base.Identifier[]? Identifier { get; set; }
    public Base.ContactPoint[]? Telecom { get; set; }
    public Base.ResourceReference[]? GeneralPractitioner { get; set; }
    public string? Gender { get; set; }
    public Base.CodeableConcept? MaritalStatus { get; set; }
    public Patient_Contact[]? Contact { get; set; }

    public class Patient_Link : BackboneElement
    {
        public required string Type { get; set; }
        public required Base.ResourceReference Other { get; set; }
    }

    public class Patient_Communication : BackboneElement
    {
        public required Base.CodeableConcept Language { get; set; }
        public bool? Preferred { get; set; }
    }

    public class Patient_Contact : BackboneElement
    {
        public Base.HumanName? Name { get; set; }
        public string? Gender { get; set; }
        public Base.Period? Period { get; set; }
        public Base.Address? Address { get; set; }
        public Base.ContactPoint[]? Telecom { get; set; }
        public Base.ResourceReference? Organization { get; set; }
        public Base.CodeableConcept[]? Relationship { get; set; }
    }
}