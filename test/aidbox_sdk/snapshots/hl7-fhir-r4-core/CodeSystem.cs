using Aidbox.FHIR.Base;
using Aidbox.FHIR.Utils;

namespace Aidbox.FHIR.Resource;

public class CodeSystem : DomainResource, IResource
{
    public string? Description { get; set; }
    public string? Date { get; set; }
    public bool? VersionNeeded { get; set; }
    public string? Publisher { get; set; }
    public Base.CodeableConcept[]? Jurisdiction { get; set; }
    public string? Purpose { get; set; }
    public required string Content { get; set; }
    public CodeSystem_Property[]? Property { get; set; }
    public string? Name { get; set; }
    public Base.UsageContext[]? UseContext { get; set; }
    public string? Copyright { get; set; }
    public bool? Experimental { get; set; }
    public string? Title { get; set; }
    public CodeSystem_Filter[]? Filter { get; set; }
    public string? Supplements { get; set; }
    public bool? Compositional { get; set; }
    public required string Status { get; set; }
    public string? HierarchyMeaning { get; set; }
    public string? ValueSet { get; set; }
    public uint? Count { get; set; }
    public string? Url { get; set; }
    public Base.Identifier[]? Identifier { get; set; }
    public CodeSystem_Concept[]? Concept { get; set; }
    public bool? CaseSensitive { get; set; }
    public string? Version { get; set; }
    public Base.ContactDetail[]? Contact { get; set; }

    public class CodeSystem_Property : BackboneElement
    {
        public string? Uri { get; set; }
        public required string Code { get; set; }
        public required string Type { get; set; }
        public string? Description { get; set; }
    }

    public class CodeSystem_Filter : BackboneElement
    {
        public required string Code { get; set; }
        public required string Value { get; set; }
        public required string[] Operator { get; set; }
        public string? Description { get; set; }
    }

    public class CodeSystem_Concept_Concept_Property : BackboneElement
    {
        public string? ValueCode { get; set; }
        public string? ValueDecimal { get; set; }
        public object? Value    
        {
            get
            {
                if (ValueCode is not null)
                {
                    return ValueCode;
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
        
                if (ValueCoding is not null)
                {
                    return ValueCoding;
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
        
                if (value?.GetType() == typeof(Base.Coding))
                {
                    ValueCoding = (Base.Coding)value;return;
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
        public Base.Coding? ValueCoding { get; set; }
        public required string Code { get; set; }
        public int? ValueInteger { get; set; }
    }

    public class CodeSystem_Concept_Concept_Designation : BackboneElement
    {
        public Base.Coding? Use { get; set; }
        public required string Value { get; set; }
        public string? Language { get; set; }
    }

    public class CodeSystem_Concept_Concept : BackboneElement
    {
        public required string Code { get; set; }
        public string[]? Concept { get; set; }
        public string? Display { get; set; }
        public CodeSystem_Concept_Concept_Property[]? Property { get; set; }
        public string? Definition { get; set; }
        public CodeSystem_Concept_Concept_Designation[]? Designation { get; set; }
    }

    public class CodeSystem_Concept_Property : BackboneElement
    {
        public string? ValueCode { get; set; }
        public string? ValueDecimal { get; set; }
        public object? Value    
        {
            get
            {
                if (ValueCode is not null)
                {
                    return ValueCode;
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
        
                if (ValueCoding is not null)
                {
                    return ValueCoding;
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
        
                if (value?.GetType() == typeof(Base.Coding))
                {
                    ValueCoding = (Base.Coding)value;return;
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
        public Base.Coding? ValueCoding { get; set; }
        public required string Code { get; set; }
        public int? ValueInteger { get; set; }
    }

    public class CodeSystem_Concept_Designation : BackboneElement
    {
        public Base.Coding? Use { get; set; }
        public required string Value { get; set; }
        public string? Language { get; set; }
    }

    public class CodeSystem_Concept : BackboneElement
    {
        public required string Code { get; set; }
        public CodeSystem_Concept_Concept[]? Concept { get; set; }
        public string? Display { get; set; }
        public CodeSystem_Concept_Property[]? Property { get; set; }
        public string? Definition { get; set; }
        public CodeSystem_Concept_Designation[]? Designation { get; set; }
    }
}