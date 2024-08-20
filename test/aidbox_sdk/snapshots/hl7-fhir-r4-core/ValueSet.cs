using Aidbox.FHIR.Base;
using Aidbox.FHIR.Utils;

namespace Aidbox.FHIR.Resource;

public class ValueSet : DomainResource, IResource
{
    public string? Description { get; set; }
    public ValueSet_Compose? Compose { get; set; }
    public string? Date { get; set; }
    public string? Publisher { get; set; }
    public Base.CodeableConcept[]? Jurisdiction { get; set; }
    public string? Purpose { get; set; }
    public string? Name { get; set; }
    public Base.UsageContext[]? UseContext { get; set; }
    public string? Copyright { get; set; }
    public bool? Experimental { get; set; }
    public ValueSet_Expansion? Expansion { get; set; }
    public string? Title { get; set; }
    public required string Status { get; set; }
    public string? Url { get; set; }
    public Base.Identifier[]? Identifier { get; set; }
    public bool? Immutable { get; set; }
    public string? Version { get; set; }
    public Base.ContactDetail[]? Contact { get; set; }

    public class ValueSet_Compose_Exclude_Filter : BackboneElement
    {
        public required string Op { get; set; }
        public required string Value { get; set; }
        public required string Property { get; set; }
    }

    public class ValueSet_Compose_Exclude_Concept_Designation : BackboneElement
    {
        public Base.Coding? Use { get; set; }
        public required string Value { get; set; }
        public string? Language { get; set; }
    }

    public class ValueSet_Compose_Exclude_Concept : BackboneElement
    {
        public required string Code { get; set; }
        public string? Display { get; set; }
        public ValueSet_Compose_Exclude_Concept_Designation[]? Designation { get; set; }
    }

    public class ValueSet_Compose_Exclude : BackboneElement
    {
        public ValueSet_Compose_Exclude_Filter[]? Filter { get; set; }
        public string? System { get; set; }
        public ValueSet_Compose_Exclude_Concept[]? Concept { get; set; }
        public string? Version { get; set; }
        public string[]? ValueSet { get; set; }
    }

    public class ValueSet_Compose_Include_Filter : BackboneElement
    {
        public required string Op { get; set; }
        public required string Value { get; set; }
        public required string Property { get; set; }
    }

    public class ValueSet_Compose_Include_Concept_Designation : BackboneElement
    {
        public Base.Coding? Use { get; set; }
        public required string Value { get; set; }
        public string? Language { get; set; }
    }

    public class ValueSet_Compose_Include_Concept : BackboneElement
    {
        public required string Code { get; set; }
        public string? Display { get; set; }
        public ValueSet_Compose_Include_Concept_Designation[]? Designation { get; set; }
    }

    public class ValueSet_Compose_Include : BackboneElement
    {
        public ValueSet_Compose_Include_Filter[]? Filter { get; set; }
        public string? System { get; set; }
        public ValueSet_Compose_Include_Concept[]? Concept { get; set; }
        public string? Version { get; set; }
        public string[]? ValueSet { get; set; }
    }

    public class ValueSet_Compose : BackboneElement
    {
        public ValueSet_Compose_Exclude[]? Exclude { get; set; }
        public required ValueSet_Compose_Include[] Include { get; set; }
        public bool? Inactive { get; set; }
        public string? LockedDate { get; set; }
    }

    public class ValueSet_Expansion_Contains_Contains : BackboneElement
    {
        public string? Code { get; set; }
        public string? System { get; set; }
        public string? Display { get; set; }
        public string? Version { get; set; }
        public bool? Abstract { get; set; }
        public string[]? Contains { get; set; }
        public bool? Inactive { get; set; }
        public string[]? Designation { get; set; }
    }

    public class ValueSet_Expansion_Contains_Designation : BackboneElement
    {
        public Base.Coding? Use { get; set; }
        public required string Value { get; set; }
        public string? Language { get; set; }
    }

    public class ValueSet_Expansion_Contains : BackboneElement
    {
        public string? Code { get; set; }
        public string? System { get; set; }
        public string? Display { get; set; }
        public string? Version { get; set; }
        public bool? Abstract { get; set; }
        public ValueSet_Expansion_Contains_Contains[]? Contains { get; set; }
        public bool? Inactive { get; set; }
        public ValueSet_Expansion_Contains_Designation[]? Designation { get; set; }
    }

    public class ValueSet_Expansion_Parameter : BackboneElement
    {
        public string? ValueCode { get; set; }
        public string? ValueUri { get; set; }
        public string? ValueDecimal { get; set; }
        public required string Name { get; set; }
        public object? Value    
        {
            get
            {
                if (ValueCode is not null)
                {
                    return ValueCode;
                }
        
                if (ValueUri is not null)
                {
                    return ValueUri;
                }
        
                if (ValueDecimal is not null)
                {
                    return ValueDecimal;
                }
        
                if (ValueString is not null)
                {
                    return ValueString;
                }
        
                if (ValueBoolean is not null)
                {
                    return ValueBoolean;
                }
        
                if (ValueDateTime is not null)
                {
                    return ValueDateTime;
                }
        
                if (ValueInteger is not null)
                {
                    return ValueInteger;
                }
        
                return null;
            }
        
            set
            {
                if (value?.GetType() == typeof(string))
                {
                    ValueCode = (string)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    ValueUri = (string)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    ValueDecimal = (string)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    ValueString = (string)value;return;
                }
        
                if (value?.GetType() == typeof(bool))
                {
                    ValueBoolean = (bool)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    ValueDateTime = (string)value;return;
                }
        
                if (value?.GetType() == typeof(int))
                {
                    ValueInteger = (int)value;return;
                }
        
                throw new ArgumentException("Invalid type provided");
            }
        }
        public string? ValueString { get; set; }
        public bool? ValueBoolean { get; set; }
        public string? ValueDateTime { get; set; }
        public int? ValueInteger { get; set; }
    }

    public class ValueSet_Expansion : BackboneElement
    {
        public int? Total { get; set; }
        public int? Offset { get; set; }
        public ValueSet_Expansion_Contains[]? Contains { get; set; }
        public ValueSet_Expansion_Parameter[]? Parameter { get; set; }
        public required string Timestamp { get; set; }
        public string? Identifier { get; set; }
    }
}